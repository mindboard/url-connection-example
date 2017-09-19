package myserver

import groovy.json.*

class ProductsController {
    static allowedMethods = [
        item:'GET',
        newitem:'POST'
    ]

    private static Map<String,Map<String,String>> db
    static {
        db = new HashMap<>()
        db.put('001', [name:'MacBook', price:'1000'])
        db.put('002', [name:'MacBook Pro', price:'1200'])
        db.put('011', [name:'iPad', price:'800'])
    }

    def item(){
        render text: new JsonBuilder( db[params.id] ).toString()
    }

    def newitem() {
        def productJson = new InputStreamReader(request.inputStream,'UTF-8').text
        db[params.id] = new JsonSlurper().parseText( productJson )
        render text: new JsonBuilder( db[params.id] ).toString()
    }
}
