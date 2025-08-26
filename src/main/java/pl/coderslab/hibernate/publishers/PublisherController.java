package pl.coderslab.hibernate.publishers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao, PublisherDao publisherDao1) {
        this.publisherDao = publisherDao1;
    }

    @RequestMapping("/publisher/create")
    @ResponseBody
    public String createPublisher(Publisher publisher) {
        Publisher newPublisher = new Publisher();
        newPublisher.setName("New publisher");
        publisherDao.save(newPublisher);
        return "New publisher created";
    }
    @RequestMapping("/publisher/read/{id}")
    @ResponseBody
    public String readPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Publisher deleted: " + publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable Long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return "Publisher updated: " + publisher.toString();
    }

}
