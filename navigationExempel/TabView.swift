//
//  TabView.swift
//  navigationExempel
//
//  Created by Bill Palmestedt on 2024-01-31.
//

import SwiftUI

struct TabView2: View {
    var body: some View {
        TabView{
            Text("sida 1")
                .tabItem { 
                    Image(systemName: "1.circle")
                    Text("tab1")
                    }
            Text("sida 2")
                .tabItem { 
                    Image(systemName: "2.circle")
                Text("tab2")}
            
            
        }
        .tabViewStyle(PageTabViewStyle())
        
        TabView{
            Text("sida 1")
                .tabItem {
                    Image(systemName: "1.circle")
                    Text("tab1")
                    }
            Text("sida 2")
                .tabItem {
                    Image(systemName: "2.circle")
                Text("tab2")}
            
            
        }
        .tabViewStyle(PageTabViewStyle())
    }
}

#Preview {
    TabView2()
}
