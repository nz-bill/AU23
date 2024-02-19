//
//  ContentView.swift
//  urlSession
//
//  Created by Bill Palmestedt on 2024-02-19.
//

import SwiftUI

struct ContentView: View {
    
    @State var posts: [Post] = []
    
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
            Button("tryck på mig"){
                getPosts()
            }
            List(posts, id: \.userId){ post in
                VStack{
                    Text(post.title)
                    Text(post.body)
                }
                .background(Color.gray)
                .padding()
                
                
            }
        }
        .padding()
    }
    
    func getPosts(){
        let apiUrl = URL(string: "https://jsonplaceholder.typicode.com/posts")!
        
        let session = URLSession.shared
        
        let task = session.dataTask(with: apiUrl) { data, response, error in
            
            if let error {
                print("error \(error.localizedDescription)")
                return
            }
            
            guard let jsonData = data else{
                print("ingen data hittades")
                return
            }
            
            do {
                let decodedData = try JSONDecoder().decode([Post].self, from: jsonData)
                
                DispatchQueue.main.async {
                    self.posts = decodedData
                }
               
//                for post in posts{
//                    print("title: \(post.title), body: \(post.body)")
//                }
            }catch{
                print("error decoding jsonData")
            }
        }
        
        task.resume()
    }
}

struct Post: Codable{
    let userId: Int
    let id: Int
    let title: String
    let body: String
}

#Preview {
    ContentView()
}
