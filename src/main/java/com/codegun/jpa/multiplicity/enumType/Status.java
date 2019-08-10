package com.codegun.jpa.multiplicity.enumType;

public enum Status {
    ENABLED{
        @Override
        public boolean isEnabled(){
            return true;
        }

    }, DISABLED{
        @Override
        public boolean isEnabled(){
            return false;
        }
    };

    public boolean isEnabled(){
        return false;
    }
}
