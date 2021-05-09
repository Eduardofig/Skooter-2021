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
#define GETSET_H(type, var)\
    private:\
        type var;\
    public:\
        void set##var(type var);\
        type get##var();\

#define GETSET_C(type, var, class)\
    type class::get##var()\
        {\
            return this->var;\
        }\
    void class::set##var(type var)\
        {\
            this->var = var;\
        }

        
