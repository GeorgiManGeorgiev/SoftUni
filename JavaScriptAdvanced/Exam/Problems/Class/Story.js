class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }


    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`
        }

        if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`
        } else {
            return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`
        }

    }

    like(username) {
        //check if username already is in likes and throw
        if (this._likes.includes(username)) {
            throw new Error('You can\'t like the same story twice!')
            return;
        }

        //check if username  is creator and throw
        if (this.creator === username.trim()) {
            throw new Error('You can\'t like your own story!')
            return;
        }
        //create a like username and push to likes
        this._likes.push(username)
        return `${username} liked ${this.title}!`


    }

    dislike(username) {
        //check if username already is in likes if not throw
        if (!this._likes.includes(username)) {
            throw new Error('You can\'t dislike this story!')
            return;
        }
        let indexOf = this._likes.indexOf(username);
        this._likes.splice(indexOf, 1);
        return `${username} disliked ${this.title}`;
    }


    comment(username, content, id) {

        let idIndex = this._comments.length + 1;
        let isCommentIdPresent;
        for (let i = 0; i < this._comments.length; i++) {
            if (this._comments[i].Id === id) {
                isCommentIdPresent = true;
            }
        }
        if (id === undefined || !isCommentIdPresent) {
            this._comments.push({Id: idIndex, Username: username, Content: content, Replies: []})
            //create comment{id, username, content, replies}
            return `${username} commented on ${this.title}`
        }
        if (isCommentIdPresent) {
            let replyId;
            for (let i = 0; i < this._comments.length; i++) {
                if (this._comments[i].Id === id) {
                    replyId = this._comments[i].Id + 0.0 + (this._comments[i].Replies.length + 1) / 10;
                    this._comments[i].Replies.push({Id: replyId, Username: username, Content: content})
                    return `You replied successfully`;
                }
            }

            //add reply {Id, Username, Content} to comment

        }


    }

    toString(sortingType) {

        if (sortingType === 'asc') {
            this._comments = this._comments.sort((a, b) => a.Id - b.Id);
            this._comments.forEach(e => {
                return e.Replies.sort((a, b) => a.Id - b.Id)
            })

            let result = [];
            result.push(`Title: ${this.title}`)
            result.push(`Creator: ${this.creator}`)
            result.push(`Likes: ${this._likes.length}`)
            result.push(`Comments:`)

            this._comments.forEach(e => {
                result.push(`-- ${e.Id}. ${e.Username}: ${e.Content}`);
                e.Replies.forEach(e=>{
                   result.push(`--- ${e.Id}. ${e.Username}: ${e.Content}`)})
            })

            return result.join('\n');
        }


        if (sortingType === 'desc') {
            this._comments = this._comments.sort((a, b) => b.Id - a.Id);
            this._comments.forEach(e => {
                return e.Replies.sort((a, b) => b.Id - a.Id)
            })

            let result = [];
            result.push(`Title: ${this.title}`)
            result.push(`Creator: ${this.creator}`)
            result.push(`Likes: ${this._likes.length}`)
            result.push(`Comments:`)

            this._comments.forEach(e => {
                result.push(`-- ${e.Id}. ${e.Username}: ${e.Content}`);
                e.Replies.forEach(e=>{
                    result.push(`--- ${e.Id}. ${e.Username}: ${e.Content}`)})
            })



            return result.join('\n');
        }
        if (sortingType === 'username') {
            this._comments = this._comments.sort((a, b) => a.Username.localeCompare(b.Username));
            this._comments.forEach(e => {
                return e.Replies.sort((a, b) => a.Username.localeCompare(b.Username))
            })

            let result = [];
            result.push(`Title: ${this.title}`)
            result.push(`Creator: ${this.creator}`)
            result.push(`Likes: ${this._likes.length}`)
            result.push(`Comments:`)

            this._comments.forEach(e => {
                result.push(`-- ${e.Id}. ${e.Username}: ${e.Content}`);
                e.Replies.forEach(e=>{
                    result.push(`--- ${e.Id}. ${e.Username}: ${e.Content}`)})
            })



            return result.join('\n');
        }
    }
}

let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));
console.log(art.toString('asc'));

//John likes this story!
// My Story has 0 likes
// Ammy commented on My Story
// You replied successfully
//
// Title: My Story
// Creator: Anny
// Likes: 0
// Comments:
// -- 2. Ammy: New Content
// -- 3. Jessy: Nice :)
// -- 1. Sammy: Some Content
// --- 1.2. SAmmy: Reply@
// --- 1.1. Zane: Reply
//
// Title: My Story
// Creator: Anny
// Likes: 1
// Comments:
// -- 3. Jessy: Nice :)
// -- 2. Ammy: New Content
// -- 1. Sammy: Some Content
// --- 1.2. SAmmy: Reply@
// --- 1.1. Zane: Reply