package instascaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CompaignController {
    @Autowired(required =false )
    private CompaignRepository campaignRepository;



    public List<Campaign> selectByCategory(List<Campaign> campaigns, String categoryName)
    {       ArrayList<Campaign> campaign=new ArrayList<>();
            for(int i=0;i<campaigns.size();i++)
            {
                if(campaigns.get(i).getCategory().equals(categoryName))
                   campaign.add(campaigns.get(i));
            }
     return campaign;
    }

    public List<Campaign> findByCountry(String country,List<Campaign> campaigns){
        ArrayList <Campaign> campaign = new ArrayList<>();
        for (int i=0;i<campaigns.size();i++)
        {
            if(campaigns.get(i).getCountry().equals(country))
            {
                campaign.add(campaigns.get(i));
            }
        }
        return campaign;
    }
    public Campaign findByName(String Name,List<Campaign> campaigns){
        for (int i=0;i<campaigns.size();i++)
        {
            if(campaigns.get(i).getName().equals(Name))
            {
                return campaigns.get(i);
            }
        }

        return null;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Campaign> all() {
        return campaignRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Campaign> addCampaign(@RequestParam(name = "Name")String name ,
                                                @RequestParam(name = "Country") String country,
                                                @RequestParam(name = "Budget") String budget,
                                                @RequestParam(name = "Goal")String goal,
                                                @RequestParam(name = "Category",required = false)String category) {
        DummyService dummy= new DummyService();
        Campaign campaign=new Campaign(name,country,goal,category,budget);
        if(!dummy.dummyCategory.contains(category))
        {
            campaign=dummy.createDummyCategory(campaign);
        }
        DataFile data=new DataFile();
        campaignRepository.save(campaign);
        data.addToFile((ArrayList<Campaign>) campaignRepository.findAll());
        return ResponseEntity.ok().body(campaign);
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public List<Campaign> groupData(@RequestParam(name = "Country") String country,
                                                    @RequestParam(name = "category") String category) {
        List<Campaign> campaigns=findByCountry(country,campaignRepository.findAll());
        return selectByCategory(campaigns,category);

    }

    @RequestMapping(value = "/duration", method = RequestMethod.POST)
    public ResponseEntity<Campaign>SetDuration(@RequestParam(name = "startDate") String startDate,
                                               @RequestParam(name = "endDate") String endDate,
                                               @RequestParam(name = "Name") String name)throws NullPointerException{
        Campaign campaign;
        campaign =findByName(name,campaignRepository.findAll());
        if(campaignRepository.findAll().indexOf(campaign)==-1)
        {
            return null;

        }
        campaign.setStartDate(startDate);
        campaign.setEndDate(endDate);
        campaignRepository.save(campaign);
        return ResponseEntity.ok().body(campaign);

    }

}
