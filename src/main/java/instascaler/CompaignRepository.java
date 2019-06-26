package instascaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
 interface CompaignRepository extends JpaRepository <Campaign,Long> {


}

