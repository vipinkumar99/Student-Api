package simple.api.pathmapping;

public interface PathMappingConstant {

	String BASE = "/";
	String ALL = "/all";
	String SAVE = "/save";
	String UPDATE = "/update";
	String ID = "id";
	String ID_PARAM = "/{" + ID + "}";

	String NAME = "name";
	String NAME_PARAM = "/fname/{" + NAME + "}";

	
	interface StudentMappings {
		String BASE = "/students";
	}

	interface AddressMappings {
		String BASE = "/address";
	}
	
	
}
