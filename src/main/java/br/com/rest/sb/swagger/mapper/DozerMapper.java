package br.com.rest.sb.swagger.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O,D> D parseObject(O objOrigem, Class<D> objDestino) {
		return mapper.map(objOrigem, objDestino);
	}
	
	public static <O,D> List<D> parseListObjects(List<O> lstObjOrigem, Class<D> objDestino) {
		List<D> objs = new ArrayList<D>();
		for (Object o : lstObjOrigem) {
			objs.add(parseObject(o, objDestino));
		}
		return objs;
	}
	
}
