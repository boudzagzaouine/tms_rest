package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Document;
import com.bagile.gmo.dto.Sinister;
import com.bagile.gmo.entities.GmoDocument;

import java.util.*;

public class DocumentMapper {
	public DocumentMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoDocumentId");
		map.put("code", "gmoDocumentCode");
		map.put("description", "gmoDocumentDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoDocument toEntity(Document document, boolean lazy) {
		if (null == document) {
			return null;
		}
		GmoDocument gmoDocument = new GmoDocument();
		gmoDocument.setGmoDocumentId(document.getId());
		gmoDocument.setGmoDocumentCode(document.getCode() != null ? document.getCode().toUpperCase() : null);
		gmoDocument.setGmoDocumentDescription(document.getDescription());
		gmoDocument.setGmoDocumentFile(document.getFile());
		gmoDocument.setGmoDocumentDesignation(document.getFileName());
		gmoDocument.setGmoDocumentDate(document.getDate());
		gmoDocument.setGmoDocumentFileType(document.getFileType());


		if(!lazy){
			gmoDocument.setOwnOwner(OwnerMapper.toEntity(document.getOwner(),true));
			gmoDocument.setGmoDocumentType(DocumentTypeMapper.toEntity(document.getDocumentType(),true));
			gmoDocument.setGmoSinister(SinisterMapper.toEntity(document.getSinister(),true));


		}
		return gmoDocument;
	}

	public static Document toDto(GmoDocument gmoDocument, boolean lazy) {
		if (null == gmoDocument) {
			return null;
		}
		Document document = new Document();
		document.setId(gmoDocument.getGmoDocumentId());
		document.setCode(gmoDocument.getGmoDocumentCode() != null ? gmoDocument.getGmoDocumentCode().toUpperCase() : null);
		document.setDescription(gmoDocument.getGmoDocumentDescription());
		document.setFile(gmoDocument.getGmoDocumentFile());
		document.setFileName(gmoDocument.getGmoDocumentDesignation());
		document.setDate(gmoDocument.getGmoDocumentDate());
		document.setFileType(gmoDocument.getGmoDocumentFileType());

		if(!lazy){
			document.setDocumentType(DocumentTypeMapper.toDto(gmoDocument.getGmoDocumentType(),true));
			document.setSinister(SinisterMapper.toDto(gmoDocument.getGmoSinister(),true));

			document.setOwner(OwnerMapper.toDto(gmoDocument.getOwnOwner(),true));

		}
		return document;

	}

	


	public static List<Document> toDtos(Iterable<? extends GmoDocument> gmoDocuments, boolean lazy) {
		if (null == gmoDocuments) {
			return null;
		}
		List<Document> documents = new ArrayList<>();

		for (GmoDocument gmoDocument : gmoDocuments) {
			documents.add(toDto(gmoDocument, lazy));
		}
		return documents;
	}

	public static Set<GmoDocument> toEntities(List<Document> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoDocument> gmoDocuments = new HashSet<>();
		for (Document document : list) {
			gmoDocuments.add(toEntity(document, lazy));
		}
		return gmoDocuments;
	}

	public static List<Document> toDtos(List<GmoDocument> gmoDocuments, boolean lazy) {
		if (null == gmoDocuments) {
			return null;
		}
		List<Document> documents = new ArrayList<>();
		for (GmoDocument gmoDocument : gmoDocuments) {
			documents.add(toDto(gmoDocument, lazy));
		}
		return documents;
	}
}
