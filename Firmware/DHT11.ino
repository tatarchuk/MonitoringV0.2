#include "DHT.h"

#define DHTPIN 11     // what pin we're connected to

#define DHTTYPE DHT11   // DHT 11 

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600); 
  dht.begin();
  establishContact();
}

void loop() {
  if (Serial.available() > 0 && Serial.read() == 'A') {
    float h = dht.readHumidity();
    float t = dht.readTemperature();

    // check if returns are valid, if they are NaN (not a number) then something went wrong!
    if (isnan(t) || isnan(h)) {
      Serial.println(000);
    } else {
      //Serial.print("Humidity: "); 
      Serial.print(t);
      Serial.print('\t');
      //Serial.print("Temperature: "); 
      Serial.print(h);
      Serial.println('\n');      
    }
  }  
}

void establishContact() {
  while (Serial.available() <= 0) {
    Serial.println(000); // send a test data
    
  }
}
