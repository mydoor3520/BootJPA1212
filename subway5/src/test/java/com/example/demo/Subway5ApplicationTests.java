package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Station;
import com.example.demo.repository.StationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Subway5ApplicationTests {

	@Autowired
	StationRepository repo;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void insertStation() {
		List<Station> list = List.of(
				Station.builder().name("대화").area("경기-고양시").line("3호선").build(),
				Station.builder().name("주엽").area("경기-고양시").line("3호선").build(),
				Station.builder().name("정발산").area("경기-고양시").line("3호선").build(),
				Station.builder().name("마두").area("경기-고양시").line("3호선").build(),
				Station.builder().name("백석").area("경기-고양시").line("3호선").build(),
				Station.builder().name("대곡").area("경기-고양시").line("3호선").build(),
				Station.builder().name("화정").area("경기-고양시").line("3호선").build(),
				Station.builder().name("원당").area("경기-고양시").line("3호선").build(),
				Station.builder().name("원흥").area("경기-고양시").line("3호선").build(),
				Station.builder().name("삼송").area("경기-고양시").line("3호선").build(),
				Station.builder().name("지축").area("경기-고양시").line("3호선").build(),
				Station.builder().name("구파발").area("서울-은평구").line("3호선").build(),
				Station.builder().name("연신내").area("서울-은평구").line("3호선").build(),
				Station.builder().name("불광").area("서울-은평구").line("3호선").build(),
				Station.builder().name("녹번").area("서울-은평구").line("3호선").build(),
				Station.builder().name("홍제").area("서울-서대문구").line("3호선").build(),
				Station.builder().name("무악재").area("서울-서대문구").line("3호선").build(),
				Station.builder().name("독립문").area("서울-종로구").line("3호선").build(),
				Station.builder().name("경복궁").area("서울-종로구").line("3호선").build(),
				Station.builder().name("안국").area("서울-종로구").line("3호선").build(),
				Station.builder().name("종로3가").area("서울-종로구").line("3호선").build(),
				Station.builder().name("을지로3가").area("서울-중구").line("3호선").build(),
				Station.builder().name("충무로").area("서울-중구").line("3호선").build(),
				Station.builder().name("동대입구").area("서울-중구").line("3호선").build(),
				Station.builder().name("약수").area("서울-중구").line("3호선").build(),
				Station.builder().name("금호").area("서울-성동구").line("3호선").build(),
				Station.builder().name("옥수").area("서울-성동구").line("3호선").build(),
				Station.builder().name("압구정").area("서울-강남구").line("3호선").build(),
				Station.builder().name("신사").area("서울-강남구").line("3호선").build(),
				Station.builder().name("잠원").area("서울-서초구").line("3호선").build(),
				Station.builder().name("고속터미널").area("서울-서초구").line("3호선").build(),
				Station.builder().name("교대").area("서울-서초구").line("3호선").build(),
				Station.builder().name("남부터미널").area("서울-서초구").line("3호선").build(),
				Station.builder().name("양재").area("서울-강남구").line("3호선").build(),
				Station.builder().name("매봉").area("서울-강남구").line("3호선").build(),
				Station.builder().name("도곡").area("서울-강남구").line("3호선").build(),
				Station.builder().name("대치").area("서울-강남구").line("3호선").build(),
				Station.builder().name("학여울").area("서울-강남구").line("3호선").build(),
				Station.builder().name("대청").area("서울-강남구").line("3호선").build(),
				Station.builder().name("일원").area("서울-강남구").line("3호선").build(),
				Station.builder().name("수서").area("서울-강남구").line("3호선").build(),
				Station.builder().name("가락시장").area("서울-송파구").line("3호선").build(),
				Station.builder().name("경찰병원").area("서울-송파구").line("3호선").build(),
				Station.builder().name("오금").area("서울-송파구").line("3호선").build()
			);
			repo.saveAll(list);
	}

}

