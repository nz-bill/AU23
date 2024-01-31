//
//  ContentView.swift
//  navigationExempel
//
//  Created by Bill Palmestedt on 2024-01-31.
//

import SwiftUI

struct ContentView: View {
    
    @State var firstName: String = ""
    
    var persons = [ Person(name: "Bill", age: 42),
    Person(name: "Bosse", age: 23),
    Person(name: "Banarne", age: 305)]
    
    var pets = [
    Pet(name: "Miklo", species: "dog"),
    Pet(name: "Maysan", species: "cat")]
    
    
    var body: some View {
        VStack{
            NavigationView{
                FirstView(Fname: $firstName)
            }
            
            //TextField("skriv ditt namn", text: $firstName)
            NavigationStack{
                VStack{
                    List{
                        ForEach(persons, id: \.self) { person in
                            NavigationLink(value: person){
                                
                                    Text(person.name)
                                    
                                
                            }
                       
                            
                        }
                        ForEach(pets, id: \.self) { pet in
                            NavigationLink(value: pet){
                                Text(pet.name)
                            }
                       
                            
                        }
                    }
                }
                .navigationTitle("Personer")
                .navigationDestination(for: Person.self) { person in
                    SecondView(person: person)
                }
                .navigationDestination(for: Pet.self){ pet in
                    Text(pet.name)
                }
            }
            
        }
        
        
        
    }
}

#Preview {
    ContentView()
}

struct SecondView: View{
    
    var person: Person
    var body: some View{
        ZStack{
            Color(.yellow)
            VStack{
                Text(person.name)
                Text("age: \(person.age)")
            }
           
            
        }
        .navigationTitle("page 2")
        
    }
}

struct FirstView: View{
    
   @Binding var Fname: String
    
    
    var body: some View{
        ZStack{
            Color(.green)
            Text("detta är sida 1")
            NavigationLink(destination: {
                SecondView(person: Person(name: Fname, age: 42))
            }, label: {
                Text("jag är en knapp")
                    .padding()
                    .background(.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            })
        }
        .navigationTitle("page 1")
        
    }
}

struct Person: Hashable{
    var name: String
    var age :Int
}

struct Pet: Hashable{
    var name: String
    var species:String
}
