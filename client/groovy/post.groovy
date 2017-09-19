def productData = '{"name":"iPad Pro","price":"1200"}'
def bytes = productData.getBytes('UTF-8')
URI uri = new URI('http://localhost:8080/products/newitem/004')

HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection()
connection.setRequestMethod("POST")
connection.setDoOutput(true)
connection.setFixedLengthStreamingMode(bytes.length)
connection.addRequestProperty("Content-Type", "application/json; charset=UTF-8")

// 送信
new DataOutputStream(connection.getOutputStream()).write(bytes)

// 受信
def resultJson = new InputStreamReader(connection.getInputStream(),'UTF-8').text
connection.disconnect()

println resultJson
