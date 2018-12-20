package work.usepdf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import work.usepdf.service.MurphyUnitsMap;

import java.util.HashMap;

@Service
public class MurphyUnitsMapImpl implements MurphyUnitsMap {

    private ApplicationContext applicationContext;

    @Autowired
    private MurphyUnitsMapImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public HashMap<Integer, String> getUnits() {
        return (HashMap<Integer, String>) applicationContext.getBean("UnitsList");
    }
}
