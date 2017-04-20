(set-env!
; :resource-paths #{"src" "resources"}
  :dependencies  '[[cljsjs/boot-cljsjs            "0.6.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom    {:project 'rowtr/rowtr-css
          :version "0.1.3"
          :description "common css for rowtr projects"}
  speak  {:theme "woodblock"})

(def +bootstrap-version+    "3.3.7")

(deftask bootstrap
  []
   (download :url (str "https://github.com/twbs/bootstrap-sass/archive/v" +bootstrap-version+ ".zip") 
             :unzip true )
  (sift :move {#"^bootstrap[^\/]/assets/fonts/bootstrap/(.*)" "bootstrap/assets/fonts/$1"})
; (sift :to-resource #{#"^bootstrap"})
  (sift :include #{#"^bootstrap/"})
  (sift :add-resource #{"bootstrap*"})
  )

(deftask build-jar
  []
  (comp
    (pom)
    (jar)))

(deftask install-jar []
  (comp
    (build-jar)
    (install)))
