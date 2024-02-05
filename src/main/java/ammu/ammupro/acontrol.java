package ammu.ammupro;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;


	@RestController
	public class acontrol  {
		@Autowired
		private repo sr;
		@GetMapping("/index")
		public String index() {
			return "welcome to index";	
		}
		@PostMapping("/posting")
		public ammu savedata(@RequestBody ammu data) {
			sr.save(data);
			return data;
		}
		@GetMapping("/allusers")
		public List<ammu> findall()
		{
			List<ammu> li= sr.findAll();
			return li;
		}
		@DeleteMapping("/delete/{rollno}")
		public String deletion(@PathVariable int rollno) {
			ammu st=sr.findById(rollno).get();
			if(st!=null) {
				sr.delete(st);
			}
			return "deleted successfully";
		}
		@PutMapping("/update")
		public ammu update(@RequestBody ammu rollno) {	
		sr.save(rollno);
			return rollno;
		}

	}
