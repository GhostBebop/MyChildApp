// Déclaration du module Angular
var app = angular.module("appResponsable", ["ngRoute"]);

// Barre de navigation
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "./vues/connexionResponsable.html",
    })
    .when("/ajoutEnfant", {
        templateUrl : "./vues/ajoutEnfant.html",
        controller : "gestionEnfantsCtrl",
    })
     .when("/creationFiches", {
        templateUrl : "./vues/ajoutFiches.html",
        controller : "gestionEnfantsCtrl",
    })
    .when("/gestionMesEnfants", {
        templateUrl : "./vues/gestionEnfants.html",
        controller : "gestionEnfantsCtrl",
    })
    .when("/gestionFiches", {
        templateUrl : "./vues/gestionFiches.html",
        controller : "gestionEnfantsCtrl"
    })
     .when("/demandesEtablissements", {
        templateUrl : "./vues/demandesEtablissements.html",
        controller : "demandesCtrl",
    })
     .when("/connexionResponsable", {
        templateUrl : "./vues/connexionResponsable.html",
        controller : "connectionCtrl",
     })
     .when("/inscriptionResponsable", {
        templateUrl : "./vues/inscriptionResponsable.html",
        controller : "inscriptionCtrl"
    });
});

app.controller("accueilResponsableCtrl", function ($scope) {
    $scope.msg = "Bonjour";
});
app.controller("connectionCtrl", function ($scope) {
    $scope.msg = "Bonjour ";
});
app.controller("inscriptionCtrl", function ($scope) {
    $scope.msg = "I love ins";
});
app.controller("gestionEnfantsCtrl", function ($scope) {
    $scope.msg = "I love mes enfants";
});
app.controller("demandesCtrl", function ($scope) {
    $scope.msg = "I love mes enfants";
});

// Connexion
app.controller('connectionResponsable',function($scope,$http,$rootScope){
	
	$scope.connexion = {};
	$scope.seConnecterResponsable=function(){
		$http.post("http://localhost:8080/projetfinalserveur/findResponsable",$scope.connexion).then(function(value){
			$rootScope.rootResponsable = value.data;
			$rootScope.myValue = true;
			$rootScope.bonjour="Vous êtes connecté";
			$scope.connexion = {};
			$scope.findAllEnfantResponsable($rootScope.rootResponsable.idUser);
			$scope.redirection();
			
		}).catch(function(reason){
			alert("Login et/ou mdp incorrects");
			console.log(reason);
			
		})
		
		
		}
		$scope.findAllEnfantResponsable=function(id){
			$http.get("http://localhost:8080/projetfinalserveur/listEnfantResponsable",{params:  {idUser : id}}).then(function(value){
				$rootScope.mesEnfants = value.data;
				
			}).catch(function(reason){
				alert("Login et/ou mdp incorrects");
				console.log(reason);
			})
		}
		
		$scope.redirection = function() {
			document.location.href = "file:///C:/Users/aabdelli/Documents/My%20child’app/ProjetFinalClientVF/WebContent/Responsable/indexResponsable.html#!/gestionMesEnfants";
			
		}
});	

// Deconnexion
app.controller('deconnection',function($scope,$rootScope){

	$scope.seDeconnecter=function(){
		$rootScope.myValue = false;
		$rootScope.rootResponsable = {};
		alert("Vous êtes déconnecté");
		$rootScope.bonjour="";
		$scope.redirection();
		
};
$scope.redirection = function() {
	document.location.href = "file:///C:/Users/aabdelli/Documents/My%20child’app/ProjetFinalClientVF/WebContent/Accueil.html";
	
}
})	

app.controller('registerResponsable',function($scope,$http){

	$scope.registerResponsable1=function(){
	$http.post("http://localhost:8080/projetfinalserveur/saveResponsable",$scope.responsable).then(function(value){
		$scope.responsable = value.data;
		
	}).catch(function(reason){
		alert("Erreur d'ajout");
		console.log(reason);
	})
	$http.post("http://localhost:8080/projetfinalserveur/createConnexionResponsable",$scope.connexion).then(function(value){
		$scope.connexion = value.data;
		$scope.registerResponsable2($scope.responsable.idUser,$scope.connexion.idConnexion);
	}).catch(function(reason){
		alert("Erreur d'ajout connexion");
		console.log(reason);
	})
	};
	
	$scope.registerResponsable2=function(id1,id2){
		$http.get("http://localhost:8080/projetfinalserveur/linkConnexionResponsable",{params:  {idResponsable : id1, idConnexion : id2}}).then(function(value){
			
		}).catch(function(reason){
			alert("Erreur d'attribution");
			console.log(reason);
		})
		$scope.responsable={};
		$scope.connexion={};
	};
		
});



app.controller('registerResponsable',function($scope,$http){

	$scope.registerResponsable1=function(){
	$http.post("http://localhost:8080/projetfinalserveur/saveResponsable",$scope.responsable).then(function(value){
		$scope.responsable = value.data;
		
	}).catch(function(reason){
		alert("Erreur d'ajout");
		console.log(reason);
	})
	$http.post("http://localhost:8080/projetfinalserveur/createConnexionResponsable",$scope.connexion).then(function(value){
		$scope.connexion = value.data;
		$scope.registerResponsable2($scope.responsable.idUser,$scope.connexion.idConnexion);
	}).catch(function(reason){
		alert("Erreur d'ajout connexion");
		console.log(reason);
	})
	};
	
	$scope.registerResponsable2=function(id1,id2){
		$http.get("http://localhost:8080/projetfinalserveur/linkConnexionResponsable",{params:  {idResponsable : id1, idConnexion : id2}}).then(function(value){
			
		}).catch(function(reason){
			alert("Erreur d'attribution");
			console.log(reason);
		})
		$scope.responsable={};
		$scope.connexion={};
	};
		
});



app.controller('registerEnfant',function($scope,$http,$rootScope){

	$scope.registerEnfant1=function(){
	$http.post("http://localhost:8080/projetfinalserveur/saveEnfant",$scope.enfant).then(function(value){
		$scope.enfant = value.data;
		$scope.registerEnfant2($scope.rootResponsable.idUser,$scope.enfant.idEnfant);
		
	}).catch(function(reason){
		alert("Erreur d'ajout d'enfant");
		console.log(reason);
	})
	}
	$scope.registerEnfant2=function(id1,id2){
		$http.get("http://localhost:8080/projetfinalserveur/linkEnfantResponsable",{params:  {idResponsable : id1, idEnfant : id2}}).then(function(value){
			$scope.findAllEnfantResponsable($scope.rootResponsable.idUser);
		}).catch(function(reason){
			alert("Erreur d'attribution");
			console.log(reason);
		})
		$scope.enfant={};
	}
	
	$scope.findAllEnfantResponsable=function(id){
		$http.get("http://localhost:8080/projetfinalserveur/listEnfantResponsable",{params:  {idUser : id}}).then(function(value){
			$rootScope.mesEnfants = value.data;
			
		}).catch(function(reason){
			alert("Erreur de liste");
			console.log(reason);
		})
		}
	
});



app.controller('selectEnfant',function($scope,$http,$rootScope){

	$scope.findAllEnfantResponsable=function(id){
	$http.get("http://localhost:8080/projetfinalserveur/listEnfantResponsable",{params:  {idUser : id}}).then(function(value){
		$scope.mesEnfants = value.data;
		
	}).catch(function(reason){
		alert("Erreur de liste");
		console.log(reason);
	})
	};
	$scope.afficherFichePrincipaleEnfant=function(id){
		$rootScope.rootEnfant = $scope.enf;
		$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipaleEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesPrincipales = value.data;
			
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheMedicalEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesMedicales = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccinEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesVaccins = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheImageEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesImages = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
	
	};
	
	
});

app.controller('supprimerFiche',function($scope,$http,$rootScope){
	$scope.supprimerFiche = function(id1,id2){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteFiche",{params:  {idFiche : id1}})
    	.then(function(response){
    		$scope.afficherFicheEnfant(id2);
    	})
    	.catch(function(reason) {
			alert("Echec suppression");
			console.log(reason);
		})
    }
	
	
	
	
	
	
	
	$scope.afficherFicheEnfant=function(id){
		$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipaleEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesPrincipales = value.data;
			
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheMedicalEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesMedicales = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccinEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesVaccins = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheImageEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesImages = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
	
	}
	
	
	
	
});
	


app.controller('findAllDemande',function($scope,$http,$rootScope){
	$scope.findAllDemande = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/findAllDemandeEnfant",{params:  {idEnfant : id}})
    	.then(function(value){
    		$scope.mesDemandes = value.data
    	})
    	.catch(function(reason) {
			alert("Echec chargement");
			console.log(reason);
		})
    }
	
	$scope.deleteDemande = function(id1,id2){
    	$http.get("http://localhost:8080/projetfinalserveur/deleteDemande",{params:  {idDemande : id1}})
    	.then(function(){  
    		$http.get("http://localhost:8080/projetfinalserveur/findAllDemandeEnfant",{params:  {idEnfant : id2}})
        	.then(function(value){
        		$scope.mesDemandes = value.data
        	})
        	.catch(function(reason) {
    			alert("Echec chargement");
    			console.log(reason);
    		})
    	})
    	.catch(function(reason) {
			alert("Echec supp");
			console.log(reason);
		})
    }
	$scope.acceptDemande = function(id1,id2,id3,id4){
		
		$http.get("http://localhost:8080/projetfinalserveur/linkFicheEtablissement",{params:  {idEtablissement : id1, idFiche : id2}})
    	.then(function(){ 
    		$http.get("http://localhost:8080/projetfinalserveur/deleteDemande",{params:  {idDemande : id3}})
        	.then(function(){  
        		$scope.findAllDemande(id4);
        	})
        	.catch(function(reason) {
    			alert("Echec supp");
    			console.log(reason);
    		})
    		
    	})
    	.catch(function(reason) {
			alert("Echec acceptation");
			console.log(reason);
		})
		    		
    	
    }


	
});

app.controller('registerFiche',function($scope,$http,$rootScope){

	$scope.registerFichePrincipale=function(){
		$scope.fiche.typeFiche = "PRINCIPALE";
	$http.post("http://localhost:8080/projetfinalserveur/saveFichePrincipale",$scope.fiche).then(function(value){
		$scope.fiche = value.data;
		$scope.register($scope.rootEnfant.idEnfant,$scope.fiche.idFiche);
	}).catch(function(reason){
		alert("Erreur d'ajout de la fiche");
		console.log(reason);
	})
	};
	
	$scope.register=function(id1,id2){
		$http.get("http://localhost:8080/projetfinalserveur/linkFicheEnfant",{params:  {idEnfant : id1, idFiche : id2}}).then(function(value){
			$scope.afficherFicheEnfant(id1);
		}).catch(function(reason){
			alert("Erreur d'attribution");
			console.log(reason);
		})
		$scope.ficheMedical={};

		$scope.ficheImage={};
		$scope.ficheVaccins={};
		$scope.fiche={};
	};
	
	$scope.registerFicheMedical=function(){
		$scope.ficheMedical.typeFiche = "MEDICAL";
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheMedical",$scope.ficheMedical).then(function(value){
			$scope.ficheMedical = value.data;
			$scope.register($scope.rootEnfant.idEnfant,$scope.ficheMedical.idFiche);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	$scope.registerFicheVaccins=function(){
		$scope.ficheVaccins.typeFiche = "VACCIN";
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheVaccin",$scope.ficheVaccins).then(function(value){
			$scope.ficheVaccins = value.data;
			$scope.register($scope.rootEnfant.idEnfant,$scope.ficheVaccins.idFiche);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	$scope.registerFicheImage=function(){
		$scope.ficheImage.typeFiche = "IMAGE";
		$http.post("http://localhost:8080/projetfinalserveur/saveFicheImage",$scope.ficheImage).then(function(value){
			$scope.ficheImage = value.data;
			$scope.register($scope.rootEnfant.idEnfant,$scope.ficheImage.idFiche);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	
	$scope.afficherFicheEnfant=function(id){
		$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipaleEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesPrincipales = value.data;
			
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheMedicalEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesMedicales = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccinEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesVaccins = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheImageEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesImages = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
	
	};
	
});


app.controller('selectFiche',function($scope,$http,$rootScope){
	$scope.selectFiche = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/findAllFicheEnfant",{params:  {idEnfant : id}})
    	.then(function(value){
    		$scope.mesFiches = value.data
    	})
    	.catch(function(reason) {
			alert("Echec chargement");
			console.log(reason);
		})
    }
	
	$scope.update = function(id){
    	$http.get("http://localhost:8080/projetfinalserveur/getFiche",{params:  {idFiche : id}})
    	.then(function(value){
    		$rootScope.ficheUpdate = value.data
    		if($rootScope.ficheUpdate.typeFiche =="PRINCIPALE"){
    			$rootScope.myVar1="fichePrincipale"

    		}
    		if($rootScope.ficheUpdate.typeFiche =="VACCIN"){
    			$rootScope.myVar1="ficheVaccin"

    		}
    		if($rootScope.ficheUpdate.typeFiche =="MEDICAL"){
    			$rootScope.myVar1="ficheMedical"

    		}
    		if($rootScope.ficheUpdate.typeFiche =="IMAGE"){
    			$rootScope.myVar1="ficheImage"

    		}
    	})
    	.catch(function(reason) {
			alert("Echec chargement");
			console.log(reason);
		})
    }
	
	$scope.dissocier = function(id1,id2){
		
    	$http.get("http://localhost:8080/projetfinalserveur/unLinkFicheEtablissement",{params:  {idFiche : id1, idEtablissement : id2}})
    	.then(function(response){
    		$scope.selectFiche($rootScope.rootEnfant.idEnfant)
    	})
    	.catch(function(reason) {
			alert("Echec dissociation");
			console.log(reason);
		})
     	  	
    };
		
});




app.controller('registerFicheUpdate',function($scope,$http,$rootScope){

	$scope.registerFichePrincipale=function(){
		
		
	$http.post("http://localhost:8080/projetfinalserveur/updateFichePrincipale",$rootScope.ficheUpdate).then(function(value){
		$rootScope.ficheUpdate = {};
		$rootScope.myVar1= {};
		$scope.afficherFicheEnfant($rootScope.rootEnfant.idEnfant);
	}).catch(function(reason){
		alert("Erreur d'ajout de la fiche");
		console.log(reason);
	})
	};
	
	
	
	$scope.registerFicheMedical=function(){
	
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheMedical",$rootScope.ficheUpdate).then(function(value){
			$rootScope.ficheUpdate = {};
			$rootScope.myVar1= {};
			$scope.afficherFicheEnfant($rootScope.rootEnfant.idEnfant);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	$scope.registerFicheVaccins=function(){
		
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheVaccin",$rootScope.ficheUpdate).then(function(value){
			$rootScope.ficheUpdate = {};
			$rootScope.myVar1= {};
			$scope.afficherFicheEnfant($rootScope.rootEnfant.idEnfant);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	$scope.registerFicheImage=function(){
		
		$http.post("http://localhost:8080/projetfinalserveur/updateFicheImage",$rootScope.ficheUpdate).then(function(value){
			$rootScope.ficheUpdate = {};
			$rootScope.myVar1= {};
			$scope.afficherFicheEnfant($rootScope.rootEnfant.idEnfant);
		}).catch(function(reason){
			alert("Erreur d'ajout de la fiche");
			console.log(reason);
		})
	};
	
	
	$scope.afficherFicheEnfant=function(id){
		$http.get("http://localhost:8080/projetfinalserveur/listFichePrincipaleEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesPrincipales = value.data;
			
			
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheMedicalEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesMedicales = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheVaccinEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesVaccins = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
		$http.get("http://localhost:8080/projetfinalserveur/listFicheImageEnfant",{params:  {idEnfant : id}}).then(function(value){
			$rootScope.mesFichesImages = value.data;
		}).catch(function(reason){
			alert("Erreur d'affichage");
			console.log(reason);
		})
		
		
	
	};
	
});

