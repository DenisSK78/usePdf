package work.usepdf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.usepdf.object.Unit;
import work.usepdf.repository.ArrayNumberLearnedUnits;
import work.usepdf.service.EnService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EnServiceImpl implements EnService {

    private final HashMap<Integer, String> unitsMap;

    @Autowired
    public EnServiceImpl(MurphyUnitsMapImpl unitsMap) {
        this.unitsMap = unitsMap.getUnits();
    }

    @Autowired
    private ArrayNumberLearnedUnits unitsNumber;

    public List<Unit> getRandomUnits(Integer numbers){

        List<Integer> numbersList = Arrays.asList(unitsNumber.getLearnedUnits());
        Integer[] numbersArr = new Integer[numbers];

        for (int j = 0; j < numbers;) {
            Integer ren = new Random().nextInt(numbersList.size());
            if (numbersList.get(ren)!=0) {
                numbersArr[j] = numbersList.get(ren);
                numbersList.set(ren, 0);
                j++;
            }
        }

        return Arrays.stream(numbersArr)
                .map(e -> new Unit(e, unitsMap.get(e)))
                .sorted(Comparator.comparing(Unit::getId))
                .collect(Collectors.toList());
    }
}
