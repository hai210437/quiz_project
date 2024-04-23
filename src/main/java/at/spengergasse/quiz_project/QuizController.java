package at.spengergasse.quiz_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private QuestionRepository repo;

    public QuizController(QuestionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/test")
    public String test(Model model) {
        System.out.println("Test wurde aufgerufen");
        Question q = repo.findById(1).get();
        model.addAttribute("test_attribute", q);
        return "quiz_test";
    }

    @PostMapping("/save")
    public String save(Question question) {
        System.out.println("Text geändert auf: " + question.getText());
        repo.save(question);
        return "redirect:/quiz/test";
    }
}
