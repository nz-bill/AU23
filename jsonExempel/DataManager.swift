//
//  DataManager.swift
//  jsonExempel
//
//  Created by Bill Palmestedt on 2024-02-19.
//

import Foundation

class DataManager{
    
    
    func personToJson(){
        
        let person = Person(name: "Bill", age: 42)
        let encoder = JSONEncoder()
        
        do{
            let jsonData = try encoder.encode(person)
            let jsonString = String(data: jsonData, encoding: .utf8)
            
            print(jsonData)
            print(jsonString!)
        } catch{
            print("error encoding person")
        }
       
        
        
    }
    
    func jsonToPerson(){
        let jsonString = """
        {
            "name": "Bosse",
            "age": 35
        }
        """
        
        let decoder = JSONDecoder()
        
        if let jsonData = jsonString.data(using: .utf8){
            do{
                let person = try decoder.decode(Person.self, from: jsonData)
                print("\(person.name), \(person.age)")
            } catch{
                print("error decoding json")
            }
        }
        else {
            print("failed to convert string to json")
        }
        
    }
    
    func saveToUserDefaults(){
        
        UserDefaults.standard.set("Banarne", forKey: "userName")
        UserDefaults.standard.set(105, forKey: "userAge")
        
        
    }
    
    
    func loadFromUserDefaults(){
        let name = UserDefaults.standard.string(forKey: "userName") ?? "fel key"
        let age = UserDefaults.standard.integer(forKey: "userAge")
        
        let person = Person(name: name, age: age)
        
        print("\(person.name), \(person.age)")
        
    }
    
    func saveObjectToUserDefaults(){
        let person = Person(name: "Nån annan", age: 345)
        let encoder = JSONEncoder()
        
        do{
            let jsonData = try encoder.encode(person)
            UserDefaults.standard.set(jsonData, forKey: "user")
            UserDefaults.standard.set(String(data: jsonData, encoding: .utf8), forKey: "userString")
        }
        catch{
            print("error encoding person")
        }
        
      
    }
    
    func loadObjectFromDataInUserDefaults(){
        let decoder = JSONDecoder()
        
        if let jsonData = UserDefaults.standard.data(forKey: "user"){
            if let person = try? decoder.decode(Person.self, from: jsonData){
                print("from data: \(person.name), \(person.age)")
            }
        }
    }
    
    func loadObjectFromStringInUserDfaults(){
        let decoder = JSONDecoder()
        
        if let personString = UserDefaults.standard.string(forKey: "userString"){
            if let jsonData = personString.data(using: .utf8){
                do{
                    let person =  try decoder.decode(Person.self, from: jsonData)
                    print("from string: \(person.name), \(person.age)")
                
                } catch{
                    print("nåt gick snett")
                }
            }
        }
        
    }
}














