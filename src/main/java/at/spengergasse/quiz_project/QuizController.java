package at.spengergasse.quiz_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private QuestionRepository repo;
    private int id = 1;
    private int score = 0;

    public QuizController(QuestionRepository repo) {
        this.repo = repo;
    }


    @GetMapping("/main")
    public String test(Model model) {
        Question q = repo.findById(id).get();
        model.addAttribute("question", q);
        return "quiz_main";
    }

    @PostMapping("/save")
    public String save(Question question, int answer) {
        id++;
        System.out.println(answer);
        for (Answer a : question.getAnswers()) {
            {

            }

        }
        return "redirect:/quiz/main";
    }
}

