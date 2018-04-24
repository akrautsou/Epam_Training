package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.VacuumCleaner;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VacuumCleanerDao implements IGoodsDao<VacuumCleaner> {
    @Override
    public void save(VacuumCleaner entity) {

    }

    @Override
    public void update(VacuumCleaner entity) {

    }

    @Override
    public void delete(VacuumCleaner entity) {

    }

    @Override
    public List<VacuumCleaner> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<VacuumCleaner> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            VacuumCleaner goods = new VacuumCleaner();
            goods.setValues(mapValue);
            if (goods.isPowerConsumptionContains(criteria.getCriteria().get(VacuumCleaner.POWER_CONSUMPTION).toString())
                    && goods.isFilterTypeContains(criteria.getCriteria().get(VacuumCleaner.FILTER_TYPE).toString())
                    && goods.isBagTypeContains(criteria.getCriteria().get(VacuumCleaner.BAG_TYPE).toString())
                    && goods.isWandTypeContains(criteria.getCriteria().get(VacuumCleaner.WAND_TYPE).toString())
                    && goods.isMotorSpeedRegulationContains(criteria.getCriteria().get(VacuumCleaner.MOTOR_SPEED_REGULATION).toString())
                    && goods.isCleaningWidthContains(criteria.getCriteria().get(VacuumCleaner.CLEANING_WIDTH).toString())) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
