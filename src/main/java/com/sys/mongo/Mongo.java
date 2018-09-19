package com.sys.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import cn.hutool.db.nosql.mongo.MongoDS;
import cn.hutool.db.nosql.mongo.MongoFactory;

public class Mongo {

	public MongoCollection<Document> getCollection(String collectionName) {
		MongoDS mongo = MongoFactory.getDS("master");
		MongoDatabase testDB = mongo.getDb("test");
//		testDB.createCollection("user");
		MongoCollection<Document> testCollection = testDB.getCollection("test");
		return testCollection;
	}

	@Test
	public void testInsertDocument() {
		MongoCollection<Document> collection = getCollection("test");
		ArrayList<Document> friends = new ArrayList<Document>();
		friends.add(new Document("name", "小明").append("age", 25).append("weight", 56.8).append("hobby",
				Arrays.asList("java", "javascript")));
		List<Document> documents = new ArrayList<Document>();
		Document document = null;
		document = new Document("name", "张三").append("hobby", Arrays.asList("java", "C", "Python")).append("age", "25");
		documents.add(document);
		document = new Document("name", "lisi").append("hobby", Arrays.asList("java")).append("friends", friends);
		documents.add(document);
		collection.insertMany(documents);
	}

	@Test
	public void testFindDocument() {
		MongoCollection<Document> collection = getCollection("test");
		FindIterable<Document> iterable = collection.find();
		MongoCursor<Document> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		collection.find();
	}

}
