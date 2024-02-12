//
//  PersonViewModel.swift
//  CoreDataFromscratch
//
//  Created by Bill Palmestedt on 2024-02-12.
//

import Foundation
import CoreData

class PersonViewModel: ObservableObject {
    
    @Published var persons: [Person] = []
    
    var container = Persistence.shared.container
    
    init(){
        self.fetchPersons()
    }
    
    func fetchPersons(){
        let request = NSFetchRequest<Person>(entityName: "Person")
      
        
        do{
            persons = try container.viewContext.fetch(request)
            print("fetch sucsess")
        } catch let error{
            print("error fetching: \(error)")
        }
        
        
    }
    
    func addPerson(name: String, age:Int){
       
        let newPerson = Person(context: container.viewContext)
        newPerson.name = name
        newPerson.age = Int16(age)
       
        saveData()
        
        
    }
    
    func updatePerson(entity: Person, newName: String, newAge: Int){
        
        entity.name = newName
        entity.age = Int16(newAge)
        
        saveData()
    }
    
    func deletePerson(indexSet: IndexSet){
        guard let index = indexSet.first else {return}
        let entity = persons[index]
        container.viewContext.delete(entity)
        saveData()
    }
    
    func deletePerson2(entity: Person){
        container.viewContext.delete(entity)
        saveData()
    }
    
    
    func saveData(){
        do {
           try container.viewContext.save()
        } catch let error{
            print("error adding person \(error)")
        }
        fetchPersons()
    }

    
}
