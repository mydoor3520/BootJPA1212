package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.XmlResult;
import com.example.demo.entity.Station;
import com.example.demo.repository.StationRepository;
import com.google.common.net.HttpHeaders;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@CrossOrigin(
		methods = {GET,POST,PUT,DELETE},
		origins = {"*"}
		)
	

@RestController
@RequestMapping("/subway5")
public class SubwayController {
	
	@Autowired
	private StationRepository repo;
	
	@PostMapping("/")
	public ResponseEntity<Station> insert(@RequestBody Station station){
		Station result = repo.save(station);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping({"/name/{name}/area/{area}/line/{line}"})
	public ResponseEntity<Station> insert(
			@PathVariable String name,
			@PathVariable String area,
			@PathVariable String line){
		Station result = repo.save(Station.builder()
									.name(name).area(area).line(line)
									.build());
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/json")
	public List<Station> list(){
		Sort sort = Sort.by(Order.asc("no"));
		return repo.findAll(sort);
	}
	
	@GetMapping("/json/page/{page}")
	public List<Station> list(@PathVariable int page){
//		페이징 적용
		Sort sort = Sort.by(Order.asc("no"));
		PageRequest pr = PageRequest.of(page - 1, 15, sort);
		Page<Station> result = repo.findAll(pr);
		return result.getContent();
	}
	
	@GetMapping("/json/name/{name}")
	public List<Station> name(@PathVariable String name){
		return repo.findByNameIgnoreCaseContainingOrderByNo(name);
	}
	
//	@GetMapping("/json/name/{name}/page/{page}")
//	public List<Station> name(@PathVariable String name, 
//								@PathVariable int page){
//		PageRequest pageRequest = PageRequest.of(page-1, 15);
//		Page<Station> result = repo.findByNameIgnoreCaseContaining(name, pageRequest);
//		return result.getContent();
//	}
	
	@GetMapping("/json/area/{area}")
	public List<Station> area(@PathVariable String area){
		return repo.findByAreaIgnoreCaseContainingOrderByNoAsc(area);
	}
	
	@GetMapping("/json/line/{line}")
	public List<Station> line(@PathVariable String line){
		return repo.findByLineIgnoreCaseContainingOrderByNoAsc(line);
	}
	
	@GetMapping("/xml")
	public ResponseEntity<XmlResult> xmlList() {
		XmlResult result = XmlResult.builder()
							.name("지하철 전체 역 정보")
							.when(String.valueOf(System.currentTimeMillis()))
							.list(repo.findAll())
						.build();
		return ResponseEntity.ok()
								.contentType(MediaType.TEXT_XML)
								.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
							.body(result);
	}
	
	@PutMapping("/")
	public ResponseEntity<Station> edit(@RequestBody Station station){
		if(station.getNo() == 0) {
			return ResponseEntity.badRequest().build();
		}
			Optional<Station> origin = repo.findById(station.getNo());
			
			if(origin.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Station data = origin.get();
			if(station.getArea() != null) data.setArea(station.getArea());
			if(station.getLine() != null) data.setLine(station.getLine());
			if(station.getName() != null) data.setName(station.getName());
			
			Station result = repo.save(data);
			return ResponseEntity.ok().body(result);
		
	}
	
	@PutMapping("/like/{no}")
	public ResponseEntity<Station> like(@PathVariable long no){
		Optional<Station> find = repo.findById(no);
		if(find.isEmpty()) return ResponseEntity.notFound().build();
		
		Station origin = find.get();
		Long recommend = origin.getRecommend();
		origin.setRecommend(recommend == null?1:recommend+1);

		Station result = repo.save(origin);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/{no}")
	public void delete(@PathVariable long no){
		repo.deleteById(no);;;
	}
}
