package instascaler;

import java.util.ArrayList;
import java.util.List;

public class DummyService {
    List<String> dummyCategory;
    DummyService(){
        dummyCategory=new ArrayList<>();
        dummyCategory.add("Technology");
        dummyCategory.add("Sports");
        dummyCategory.add("Family & Relationships");
        dummyCategory.add("Food");
        dummyCategory.add("Health");
        dummyCategory.add("Beauty");
        dummyCategory.add("Stock Market");
        dummyCategory.add("Automotive");
        dummyCategory.add("News");

    }
    public Campaign createDummyCategory(Campaign campaign){
        if(campaign.getName().compareTo("tech")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Technology")));
        }
        else if(campaign.getName().compareTo("sport")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Sport")));
        }
        else if(campaign.getName().compareTo("health")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Health")));
        }
        else if(campaign.getName().compareTo("skinCare")>0||campaign.getName().compareTo("hairCare")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Beauty")));
        }
        else if(campaign.getName().compareTo("car")>0){

            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Automotive")));
        }
        else if(campaign.getName().compareTo("stock")>0||campaign.getName().compareTo("fund")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Stock Market")));
        }
        else if(campaign.getName().compareTo("food")>0||campaign.getName().compareTo("eat")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("Food")));
        }
        else if(campaign.getName().compareTo("arab")>0||campaign.getName().compareTo("egy")>1||campaign.getName().compareTo("new")>0){
            campaign.setCategory(dummyCategory.get(dummyCategory.indexOf("News")));
        }
        else campaign.setCategory("Other");
        return campaign;
    }
}
