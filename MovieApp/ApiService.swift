//
//  ApiService.swift
//  MovieApp
//
//  Created by Bill Palmestedt on 2024-02-21.
//

import Foundation

struct ApiService{
    static let shared = ApiService()
    let baseUrl = URL(string: "https://api.themoviedb.org/3")
    
    let headers = [
      "accept": "application/json",
      "Authorization": "Bearer <<<access token>>>"
    ]

    func getMovie(query: String, completion: @escaping (Result<[Movie], Error>) -> Void){
      
        let queryItems = [URLQueryItem(name: "query", value: query),
                          URLQueryItem(name: "include_adult", value: "false")]
        
        let request = NSMutableURLRequest(url: (baseUrl?.appending(path: "search/movie").appending(queryItems: queryItems))!)
        
        request.httpMethod = "GET"
        request.allHTTPHeaderFields = headers
        
        let session = URLSession.shared
        
        let dataTask = session.dataTask(with: request as URLRequest) { data, response, error in
            if(error != nil){
                print(error as Any)
            } else{
                //print(String(data: data!, encoding: .utf8) as Any)
                let movies = self.extractMovies(jsondata: data!)
                
                completion(.success(movies))
               // completion(.failure(Error.self as! Error))
                
            }
        }
        
        dataTask.resume()
       
        
    }
    
    func extractMovies(jsondata: Data) -> [Movie]{
        
        do{
            if let jsonDictionary = try? JSONSerialization.jsonObject(with: jsondata, options: []) as? [String: Any]{
                if let resultArray = jsonDictionary["results"] as? [[String: Any]]{
                  
                    if let jsonArray = try? JSONSerialization.data(withJSONObject: resultArray, options: []){
                        let decodedData = try JSONDecoder().decode([Movie].self, from: jsonArray)
                        
                        return decodedData
                    }
                }
            }
       
            
        } catch {
            print(error)
        }
        
        return []
    }
    
}














