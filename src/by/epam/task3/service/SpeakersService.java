package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.SpeakersDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Speakers;

import java.util.List;
import java.util.Scanner;

public class SpeakersService implements IGoodsService<Speakers> {
    private SpeakersDao speakersDao = new SpeakersDao();


    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Speakers".toUpperCase());
        Viewer.output(Speakers.POWER_CONSUMPTION + "= ");
        criteria.add(Speakers.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Speakers.NUMBER_OF_SPEAKERS + "= ");
        criteria.add(Speakers.NUMBER_OF_SPEAKERS, scanner.nextLine());
        Viewer.output(Speakers.FREQUENCY_RANGE + "= ");
        criteria.add(Speakers.FREQUENCY_RANGE, scanner.nextLine());
        Viewer.output(Speakers.CORD_LENGTH + "= ");
        criteria.add(Speakers.CORD_LENGTH, scanner.nextLine());
        return criteria;
    }


    @Override
    public void search(Criteria criteria) {
        List<Speakers> goodsList = speakersDao.search(criteria);
        for (Speakers anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }

    @Override
    public void editor() {
        List<Speakers> speakersList = speakersDao.search(new Criteria("Speakers".toUpperCase()));
        for (int i = 0; i < speakersList.size(); i++) {
            Viewer.output(i + " - " + speakersList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("POWER_CONSUMPTION");
        String powerConsumption = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("NUMBER_OF_SPEAKERS");
        String numberOfSpeakers = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("FREQUENCY_RANGE");
        String frequencyRange = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("CORD_LENGTH");
        String cordLength = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (speakersList.size() > Integer.parseInt(choice)) {
                Speakers speakers = speakersList.get(Integer.parseInt(choice));
                speakers.setPowerConsumption(Double.valueOf(powerConsumption));
                speakers.setNumberOfSpeakers(Double.valueOf(numberOfSpeakers));
                speakers.setFrequencyRange(frequencyRange);
                speakers.setCordLength(Double.valueOf(cordLength));
                speakersDao.update(speakersList);
            } else {
                Viewer.output("Error");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            Viewer.output("Error");
            System.exit(0);
        }
    }
}
