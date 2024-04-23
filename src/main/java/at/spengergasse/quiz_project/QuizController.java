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
    private UserRepository userRepo;
    private int id = 1;
    private int score = 0;
    private int questions = repo.findAll().size();
    private Question q;

    public QuizController(QuestionRepository repo, UserRepository userRepo) {

        this.repo = repo;
        this.userRepo = userRepo;
    }


    @GetMapping("/main")
    public String test(Model model) {
        q = repo.findById(id).get();
        model.addAttribute("question", q);
        return "quiz_main";
    }

    @PostMapping("/save")
    public String save(int answer) {
        for (Answer a : q.getAnswers()) {
            {
                if (a.getCorrect() && a.getId() == answer) {
                    score++;
                }
            }

        }
        if(id == questions) {
            return "redirect:/quiz/endpage";
        }
        else {
            id++;
            return "redirect:/quiz/main";
        }
    }

    @GetMapping("/scoreboard")
    public String scoreboard(Model model) {
        var list = userRepo.findAll();
        list.sort((u1, u2) -> u2.getScore() - u1.getScore());
        model.addAttribute("users", list);
        return "scoreboard";
    }

    @GetMapping("/endpage")
    public String endpage(Model model) {
        model.addAttribute("score",score);
        return "endpage";
    }
    @PostMapping("/saveuser")
    public String saveuser(String usernamefield) {
        User user = new User();
        user.setUsername(usernamefield);
        user.setScore(score);
        userRepo.save(user);
        return "redirect:/quiz/scoreboard";
    }
}

