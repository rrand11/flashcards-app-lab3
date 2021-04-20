import UIKit

class MainViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource  {

    @IBOutlet var collectionView: UICollectionView!
    var cardsets: [FlashcardSet] = [FlashcardSet]()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        cardsets = FlashcardSet.getHardCodedCollection()
        collectionView.delegate = self
        collectionView.dataSource = self
    }
    
    @IBAction func addNewSet(_ sender: Any) {
        let newSet = FlashcardSet()
        newSet.title = "Title \(cardsets.count + 1)"
        cardsets.append(newSet)
        collectionView.reloadData()
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return cardsets.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "SetCell", for: indexPath) as! FlashcardSetCollectionCell
        //setup method just makes it look nice
        //cell.setup()
        cell.textLabel.text = cardsets[indexPath.row].title
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        //go to new view
        performSegue(withIdentifier: "GoToDetail", sender: self)
    }
}

