//
//  Person.swift
//  SwiftData2
//
//  Created by Bill Palmestedt on 2024-02-12.
//

import Foundation
import SwiftData


@Model
class Person{
    var name: String
    var age: Int
    
    init(name: String, age: Int) {
        self.name = name
        self.age = age
    }
}
