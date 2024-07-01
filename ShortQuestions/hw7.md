# Chuwa Homework& MingHao(Howard) Lee 

# Homework part 1: Postman practice

## Practice with below examples (You can find any Open APIs on the internet):
 - ## 5 GET APIs with different response type
 - API: JSONPlaceholder (Fake Online REST API for Testing)
 - Endpoint: https://jsonplaceholder.typicode.com/posts/1
 - Status: 200 OK 
 - responce:
   ```JSON
      {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit..."
      }

   ```

 - API: United States Geological Survey (USGS) Earthquake Data
 - Endpoint: [https://jsonplaceholder.typicode.com/posts/1](https://earthquake.usgs.gov/fdsnws/event/1/query?format=xml&starttime=2024-06-01&endtime=2024-06-02&minmagnitude=5)
 - Status: 200 OK 
 - responce:
   ```XML
      <?xml version="1.0" encoding="UTF-8"?>
      <q:quakeml xmlns="http://quakeml.org/xmlns/bed/1.2" xmlns:anss="http://anss.org/xmlns/event/0.1" xmlns:catalog="http://anss.org/xmlns/catalog/0.1" xmlns:q="http://quakeml.org/xmlns/quakeml/1.2">
          <eventParameters publicID="quakeml:earthquake.usgs.gov/fdsnws/event/1/query?format=xml&amp;starttime=2024-06-01&amp;endtime=2024-06-02&amp;minmagnitude=5">
              <event catalog:datasource="us" catalog:eventsource="us" catalog:eventid="7000mpge" publicID="quakeml:earthquake.usgs.gov/fdsnws/event/1/query?eventid=us7000mpge&amp;format=quakeml">
                  <description>
                      <type>earthquake name</type>
                      <text>40 km ESE of Ransiki, Indonesia</text>
                  </description>
                  <origin catalog:datasource="us" catalog:dataid="us7000mpge" catalog:eventsource="us" catalog:eventid="7000mpge" publicID="quakeml:earthquake.usgs.gov/product/origin/us7000mpge/us/1718971585040/product.xml">
                      <time>
                          <value>2024-06-01T11:01:43.411Z</value>
                      </time>
                      <longitude>
                          <value>134.5006</value>
                      </longitude>
                      <latitude>
                          <value>-1.6626</value>
                      </latitude>
                      <depth>
                          <value>36038</value>
                          <uncertainty>7525</uncertainty>
                      </depth>
                      <originUncertainty>
                          <horizontalUncertainty>9570</horizontalUncertainty>
                          <preferredDescription>horizontal uncertainty</preferredDescription>
                      </originUncertainty>
                      <quality>
                          <usedPhaseCount>38</usedPhaseCount>
                          <usedStationCount>38</usedStationCount>
                          <standardError>0.34</standardError>
                          <azimuthalGap>72</azimuthalGap>
                          <minimumDistance>2.573</minimumDistance>
                      </quality>
                      <evaluationMode>manual</evaluationMode>
                      <creationInfo>
                          <agencyID>us</agencyID>
                          <creationTime>2024-06-21T12:06:25.040Z</creationTime>
                      </creationInfo>
                  </origin>
                  <magnitude catalog:datasource="us" catalog:dataid="us7000mpge" catalog:eventsource="us" catalog:eventid="7000mpge" 
              </event>
              <creationInfo>
                  <creationTime>2024-07-01T22:35:45.000Z</creationTime>
              </creationInfo>
          </eventParameters>
      </q:quakeml>

   ```

 - API: JSONPlaceholder (Fake Online REST API for Testing)
 - Endpoint: [https://jsonplaceholder.typicode.com/posts/1](https://jsonplaceholder.typicode.com/posts/999999)
 - Status: 404 Error
 - responce:
 ```JSON
   {
     "error": "Not Found"
   }
 ```
 - API: httpbin (Simple HTTP Request & Response Service)
 - Endpoint: https://httpbin.org/basic-auth/user/passwd
 - Status: 401 Unauthorized
 - responce:
   ```HTML
     <html>
       <head>
         <title>401 Authorization Required</title>
       </head>
       <body>
         <h1>401 Authorization Required</h1>
         <p>This server could not verify that you are authorized to access the document requested.</p>
       </body>
     </html>

   ```
 - API: httpstat.us (Simple HTTP Request & Response Service)
 - Endpoint: https://httpstat.us/500
 - Status: 500 Internal Server Error
 - responce:
 ```ARDUINO
   500 Internal Server Error
 ```

   
 - ## 5 Post API with json request body, please also paste the response here
   - 
 - 3 PUT API with json request body, please also paste the response here
 - 2 DELETE API
 - ## Each example with 404, 401,500 and any http status codes you know
