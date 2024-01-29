package org.sample.java.tenniskata;

public enum PointsEnum {
    LOVE,
    FIFTEEN,
    THIRTY,
    FOURTY,
    ADVANTAGE;

    public PointsEnum next() {
        switch (this) {
            case LOVE:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FOURTY;
            case FOURTY:
                return ADVANTAGE;
            case ADVANTAGE:
                return ADVANTAGE;
            default:
                return null;
        }
    }
}
