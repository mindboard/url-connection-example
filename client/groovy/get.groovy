URI uri = new URI('http://localhost:8080/products/item/001')
HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection()
connection.setRequestMethod("GET")
def resultJson = new InputStreamReader(connection.getInputStream(),'UTF-8').text
connection.disconnect()
println resultJson
