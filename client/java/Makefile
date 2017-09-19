
all : Get.class Post.class 
	java Get
	java Post

Get.class : Get.java
	javac $<

Post.class : Post.java
	javac $<

clean :
	rm -f *.class
