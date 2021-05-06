#define GETSET(type, var)\
    public:\
        type var;\
    private:\
        void set##var(type var)\
            {\
                this->var = var;\
            }\
        type get##var()\
            {\
                return this->var;\
            }
