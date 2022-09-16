package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.DocumentType;
import com.bagile.gmo.entities.GmoDocumentType;

import java.util.*;

public class DocumentTypeMapper {
	public DocumentTypeMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoDocumentTypeId");
		map.put("code", "gmoDocumentTypeCode");
		map.put("description", "gmoDocumentTypeDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoDocumentType toEntity(DocumentType documentType, boolean lazy) {
		if (null == documentType) {
			return null;
		}
		GmoDocumentType gmoDocumentType = new GmoDocumentType();
		gmoDocumentType.setGmoDocumentTypeId(documentType.getId());
		gmoDocumentType.setGmoDocumentTypeCode(documentType.getCode() != null ? documentType.getCode().toUpperCase() : null);
		gmoDocumentType.setGmoDocumentTypeDescription(documentType.getDescription());

		if(!lazy){
			gmoDocumentType.setOwnOwner(OwnerMapper.toEntity(documentType.getOwner(),true));


		}
		return gmoDocumentType;
	}

	public static DocumentType toDto(GmoDocumentType gmoDocumentType, boolean lazy) {
		if (null == gmoDocumentType) {
			return null;
		}
		DocumentType documentType = new DocumentType();
		documentType.setId(gmoDocumentType.getGmoDocumentTypeId());
		documentType.setCode(gmoDocumentType.getGmoDocumentTypeCode() != null ? gmoDocumentType.getGmoDocumentTypeCode().toUpperCase() : null);
		documentType.setDescription(gmoDocumentType.getGmoDocumentTypeDescription());

		if(!lazy){

			documentType.setOwner(OwnerMapper.toDto(gmoDocumentType.getOwnOwner(),true));

		}
		return documentType;

	}




	public static List<DocumentType> toDtos(Iterable<? extends GmoDocumentType> gmoDocumentTypes, boolean lazy) {
		if (null == gmoDocumentTypes) {
			return null;
		}
		List<DocumentType> documentTypes = new ArrayList<>();

		for (GmoDocumentType gmoDocumentType : gmoDocumentTypes) {
			documentTypes.add(toDto(gmoDocumentType, lazy));
		}
		return documentTypes;
	}

	public static Set<GmoDocumentType> toEntities(List<DocumentType> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoDocumentType> gmoDocumentTypes = new HashSet<>();
		for (DocumentType documentType : list) {
			gmoDocumentTypes.add(toEntity(documentType, lazy));
		}
		return gmoDocumentTypes;
	}

	public static List<DocumentType> toDtos(List<GmoDocumentType> gmoDocumentTypes, boolean lazy) {
		if (null == gmoDocumentTypes) {
			return null;
		}
		List<DocumentType> documentTypes = new ArrayList<>();
		for (GmoDocumentType gmoDocumentType : gmoDocumentTypes) {
			documentTypes.add(toDto(gmoDocumentType, lazy));
		}
		return documentTypes;
	}
}
