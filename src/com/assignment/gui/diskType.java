package com.assignment.gui;

import java.util.ArrayList;
import java.util.List;

public enum diskType {
  AUDIOCD {
    public String getString() {
      return "audioCD";
    }

    public diskType getEnum() {
      return AUDIOCD;
    }

    @Override
    public int getEnumValue() {
      return 0;
    }
  },
  VINYL {
    public String getString() {
      return "vinyl";
    }

    public diskType getEnum() {
      return VINYL;
    }

    @Override
    public int getEnumValue() {
      return 1;
    }
  };
  public static List<diskType> getIteration() {
    List<diskType> diskTypes = new ArrayList<diskType>();
    for (diskType t : diskType.values()) {
      diskTypes.add(t.getEnum());
    }
    return diskTypes;
  }

  public abstract String getString();

  public abstract diskType getEnum();

  public abstract int getEnumValue();
}
