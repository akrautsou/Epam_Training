package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.Map;

public class Speakers implements IGoods {
    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String NUMBER_OF_SPEAKERS = "NUMBER_OF_SPEAKERS";
    public static final String FREQUENCY_RANGE = "FREQUENCY_RANGE";
    public static final String CORD_LENGTH = "CORD_LENGTH";

    private Double powerConsumption;
    private Double numberOfSpeakers;
    private String frequencyRange;
    private Double cordLength;

    public Speakers() {
    }

    public Speakers(Double powerConsumption, Double numberOfSpeakers, String frequencyRange, Double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    private void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    private void setNumberOfSpeakers(Double numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    private void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public Double getCordLength() {
        return cordLength;
    }

    private void setCordLength(Double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public String toString() {
        return "Speakers : " +
                "Power Consumption=" + powerConsumption +
                ", Number of speakers=" + numberOfSpeakers +
                ", Frequency range=" + frequencyRange +
                ", Cord Length=" + cordLength
                + "\n";
    }

    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue : value.entrySet()) {
            if (Speakers.POWER_CONSUMPTION.equals(aValue.getKey().toUpperCase())) {
                setPowerConsumption(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Speakers.NUMBER_OF_SPEAKERS.equals(aValue.getKey().toUpperCase())) {
                setNumberOfSpeakers(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Speakers.FREQUENCY_RANGE.equals(aValue.getKey().toUpperCase())) {
                setFrequencyRange(aValue.getValue().toString());
            }
            if (Speakers.CORD_LENGTH.equals(aValue.getKey().toUpperCase())) {
                setCordLength(Double.parseDouble(aValue.getValue().toString()));
            }
        }
    }

    public boolean isPowerConsumptionContains(String value) {
        return value.isEmpty() || getPowerConsumption() != null && getPowerConsumption() >= Double.valueOf(value);
    }

    public boolean isNumberOfSpeakersContains(String value) {
        return value.isEmpty() || getNumberOfSpeakers() != null && getNumberOfSpeakers() >= Double.valueOf(value);
    }

    public boolean isFrequencyRangeContains(String value) {
        return value.isEmpty() || getFrequencyRange() != null && getFrequencyRange().equals(value);
    }

    public boolean isCordLengthContains(String value) {
        return value.isEmpty() || getCordLength() != null && getCordLength() <= Double.valueOf(value);
    }

}