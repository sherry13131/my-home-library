package com.mylibrary.type;

import java.util.ArrayList;
import java.util.List;

public enum DiskType {
  AUDIOCD {
    public String getString() {
      return "audioCD";
    }

    public DiskType getEnum() {
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

    public DiskType getEnum() {
      return VINYL;
    }

    @Override
    public int getEnumValue() {
      return 1;
    }
  };
  public static List<DiskType> getIteration() {
    List<DiskType> DiskTypes = new ArrayList<DiskType>();
    for (DiskType t : DiskType.values()) {
      DiskTypes.add(t.getEnum());
    }
    return DiskTypes;
  }

  public abstract String getString();

  public abstract DiskType getEnum();

  public abstract int getEnumValue();
}