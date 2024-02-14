//
//  ContentViewTest.swift
//  KlassrumsExempelTests
//
//  Created by Bill Palmestedt on 2024-02-14.
//

import XCTest
@testable import KlassrumsExempel

final class ContentViewTest: XCTestCase {
    
    var contentView: ContentView!
    
     override func setUp() {
        contentView = ContentView()
    }
    
    override func tearDown() {
        contentView = nil
    }
    
    func testAddNumbersReturnsSum(){
        
        //arrange
        let a = 2
        let b = 3
        let expected = 5
        
        //action
        let actualResult = contentView.addNumbers(a: a, b: b)
        
        //assert
        XCTAssertEqual(expected, actualResult, "actualResult should be \(a+b)")
    }
    
    func testAddNumbersMultipleCases(){
        //Arrange
        let testCases: [(a: Int, b: Int, expected: Int)] = [
        (1,2,3),
        (-1,1,0),
        (10, 0, 10),
        (0,0,0)
        ]
        
        //Action & Assert
        for testCase in testCases {
            XCTAssertEqual(contentView.addNumbers(a: testCase.a, b: testCase.b), testCase.expected,
                           "\(testCase.a) + \(testCase.b) should be equal to \(testCase.expected)")
        }
        
        
        
        
        
    }
    
    func testReturnSquaredReturnsSqured(){
        
        //arrange
        let number = 10
        let expected = 100
        
        //action
        let actualResult = contentView.returnSquared(number: number)
        
        //assert
        XCTAssertEqual(expected, actualResult, "actualResult should be \(String(number * number))")
        
    }
    
    func testDivideNumbersREturnQuota(){
        
        //arrange
        let a = 10
        let b = -2
        let expected = -5.0
        
        //action
        let actualResult = contentView.divideNumbers(a: a, b: b)
        
        //assert
        XCTAssertEqual(expected, actualResult, "actualResult should be \(Double(a)/Double(b))")
        
        
    }
    
    
    
    

    
}
