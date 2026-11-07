package in.ashokit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo;
	
	
	public  String loadForm(Model model) {
		loadFormData(model);
		
		return "index";
	}


	private void loadFormData(Model model) {
		List<String>courseList=new ArrayList<>();
		courseList.add("Java");
		courseList.add("Python");
		courseList.add("Devops");
		courseList.add("AWS");
		
		
		List<String>timingsList=new ArrayList<>();
		timingsList.add("Morining");
		timingsList.add("AfterNoon");
		timingsList.add("Evening");
		
		Student student =new Student();
		
		model.addAttribute("courses", courseList);
		model.addAttribute("timings", timingsList);

		model.addAttribute("student", student);
	}
		
		
		@PostMapping("/save")
		public String handleSubmit(Student s,Model model) {
			System.out.println(s);
			
			StudentEntity entity=new StudentEntity();
			BeanUtils.copyProperties(s, entity);
			
			entity.setTimings(Arrays.toString(s.getTimings()));
			
			repo.save(entity);
			
			model.addAttribute("msg","Student Saved");
			loadForm(model);
			return "index";
		
		
	}

}
