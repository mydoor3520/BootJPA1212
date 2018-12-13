package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Station;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Builder;
import lombok.Data;

/*
 * 사용자가 보게될 XML 문서의 형태
 *  - name : 문서의 이름
 *  - time : 문서 발행 시간
 *  - list : Station 데이터 집합
 *  <result>
 *  	<name>...</name>
 *  	<time>...</time>
 *  	<station-list>
 *  		<station>...</station>
 *  		<station>...</station>
 *  		...
 *  	</station-list>
 *  </result>
 */
@Data
@Builder
@JacksonXmlRootElement(localName="result")
public class XmlResult {
	private String name;
	private String when;
	
	@JacksonXmlElementWrapper(localName="station-list")// 목록이름
	@JacksonXmlProperty(localName="station")	//요소이름(클래스 설정 무시)
	private List<Station> list;
	
}




