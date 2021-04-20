import Foundation
import UIKit

class FlashCardSetDetailViewController: UIViewController, UITableViewDelegate, UITableViewDataSource
{
    var card: [Flashcard] = [Flashcard]()
    @IBOutlet var buttonView: UIView!
    @IBOutlet var tableView: UITableView!
    @IBOutlet var delete: UIButton!
    @IBOutlet var study: UIButton!
    @IBOutlet var add: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        card = Flashcard.getHardCodedCollection()
        tableView.delegate = self
        tableView.dataSource = self
    }
    
    //adds card
    @IBAction func addCard(_ sender: Any) {
        let newCard = Flashcard()
        newCard.term = "Term \(card.count + 1)"
        newCard.definition = "Definition \(card.count + 1)"
        card.append(newCard)
        tableView.reloadData()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return card.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CardCell", for: indexPath) as! FlashcardTableViewCell
        cell.flashcardLabel.text = card[indexPath.row].term
        return cell
    }
    
    
}
