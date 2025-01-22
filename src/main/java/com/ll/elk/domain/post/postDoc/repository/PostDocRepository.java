package com.ll.elk.domain.post.postDoc.repository;

import com.ll.elk.domain.post.postDoc.document.PostDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

public interface PostDocRepository extends ElasticsearchRepository<PostDoc, String> {
    @Query("""
        {
            "bool": {
                "should": [
                    {
                        "match": {
                            "title": "?0"
                        }
                    },
                    {
                        "match": {
                            "content": "?0"
                        }
                    }
                ]
            }
        }
    """)
    List<PostDoc> searchByKeyword(String keyword);
}
