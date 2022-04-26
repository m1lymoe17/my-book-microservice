package uz.pdp.emailsender.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import uz.pdp.clients.bookAndAuthor.Book;
import uz.pdp.clients.bookAndAuthor.BookAndAuthorClient;
import uz.pdp.clients.user.UserClient;
import uz.pdp.emailsender.dto.BookReview;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserClient userClient;

    @Autowired
    BookAndAuthorClient bookAndAuthorClient;

    @Value("${spring.mail.username}")
    String myEmail;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ReceiverMessages(BookReview bookReview) {
        try {

            Book book = bookAndAuthorClient.getBookById(bookReview.getBookId());
            String currentUserEmail = userClient.getUserEmailByUserId(book.getCurrentUserId());
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(myEmail);
            helper.setTo(currentUserEmail);
            helper.setText("http://localhost:8086/api/book-review/allReviews/" + bookReview.getBookId());
            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}