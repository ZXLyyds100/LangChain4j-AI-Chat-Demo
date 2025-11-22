package com.anastasio.aicodehelper.ai.rag;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RagConfig {

    @Resource
    private EmbeddingModel qwen;
    @Resource
    private EmbeddingStore<TextSegment> store;
    @Bean
    public ContentRetriever contentRetriever() {
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("src/main/resources/docs");
        DocumentByParagraphSplitter splitter = new DocumentByParagraphSplitter(1000, 200);
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(splitter)
                .textSegmentTransformer(textSegment -> TextSegment.from(textSegment.metadata().getString("file_name")
                        + textSegment.text(), textSegment.metadata()))
                .embeddingModel(qwen)
                .embeddingStore(store)
                .build();
        ingestor.ingest(documents);
        EmbeddingStoreContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)
                .embeddingModel(qwen)
                .maxResults(5)
                .minScore(0.75)
                .build();
        return contentRetriever;
    }
}
