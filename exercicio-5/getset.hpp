#define GETSET(type, var)\
    private:\
        type var;\
    public:\
        void set##var(type var)\
            {\
                this->var = var;\
            }\
        type get##var()\
            {\
                return this->var;\
            }
