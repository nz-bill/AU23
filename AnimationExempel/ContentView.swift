//
//  ContentView.swift
//  AnimationExempel
//
//  Created by Bill Palmestedt on 2024-02-28.
//

import SwiftUI

struct ContentView: View {
    
    @State var currentColor = Color.red
    @State var isChecked = false
    @State var textAnimation = false
    
    @State var ballPosition = CGPoint(x: 200, y: 200)
    @State var ballVelocity = CGVector(dx: 5, dy: 5)
    
    var body: some View {
    
        VStack {
            Rectangle()
                .frame(width: 200, height: 200)
                .foregroundColor(currentColor)
                .gesture(DragGesture().onChanged({ gesture in
                    let newColor = colorize(position: gesture.location)
                    withAnimation(){
                        self.currentColor = newColor
                    }
                    
                }))
            
                Circle()
                .frame(width: 20)
                .position(ballPosition)
                .onAppear(){
                    Timer.scheduledTimer(withTimeInterval: 0.03, repeats: true) { _ in
                        updateBallPosition()
                    }
                 
                }
                
            
            
            VStack{
                if isChecked {
                    Image(systemName: "checkmark.square.fill")
                        .imageScale(.large)
                        .foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                        .transition(.slide)
                } else {
                    Image(systemName: "checkmark.square")
                        .imageScale(.large)
                        .foregroundColor(.green)
                        .scaleEffect(2)
                        .transition(.move(edge: .bottom))
                }
            }
            .padding()
            .onTapGesture {
                withAnimation(Animation.easeInOut(duration: 0.3)){
                    isChecked.toggle()
                }
              
            }
            
            VStack{
                Image(systemName: isChecked ? "checkmark.square.fill" : "checkmark.square")
                    .imageScale(.large)
                    .foregroundColor(isChecked ? .green : .blue)
                    .scaleEffect(isChecked ? 2 : 1)
                    .transition(.slide)
            }
            .padding()
            .onTapGesture {
                withAnimation (Animation.easeInOut(duration: 1)){
                    isChecked.toggle()
                }
            }
           
            VStack{
                Text("Hello, world!")
                    .padding(20)
                    .background(Color.gray).cornerRadius(10)
                    .scaleEffect(textAnimation ? 2.5 : 1)
                    .offset(x: 0, y: textAnimation ? -200 : 0)
                
            }.onTapGesture {
                withAnimation(.spring(response: 0.9, dampingFraction: 0.3)){
                    textAnimation.toggle()
                }
            }
            
           
        }
        .padding()
    }
    
    func updateBallPosition(){
        ballPosition.x += ballVelocity.dx
        ballPosition.y += ballVelocity.dy
        
        if ballPosition.x < 0 || ballPosition.x > 380{
            ballVelocity.dx *= -1
        }
        
        if ballPosition.y < 0 || ballPosition.y > 500{
            ballVelocity.dy *= -1
        }
    }
    
    func colorize(position: CGPoint) -> Color{
        let hue = Double(position.x / 200)
        
        return Color(hue: hue, saturation: 1, brightness: 1)
        
    }
}



#Preview {
    ContentView()
}
